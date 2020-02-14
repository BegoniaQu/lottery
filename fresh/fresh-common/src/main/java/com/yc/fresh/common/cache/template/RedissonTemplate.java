package com.yc.fresh.common.cache.template;

import io.netty.channel.EventLoopGroup;
import org.redisson.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by quyang on 2017/6/9.
 *
 */
public class RedissonTemplate {

    private static final Logger log = LoggerFactory.getLogger("RedissonTemplate");

    private RedissonClient redissonClient;

    public RedissonTemplate(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }


    public <T> void set(String key, T value, Long second) {
        try {
            RBucket<T> rBucket = redissonClient.getBucket(key);
            if(second != null){
                rBucket.set(value, second, TimeUnit.SECONDS);
            }else{
                rBucket.set(value);
            }
        } catch (Exception e) {
            log.error("redisson: set operation error",e);
        }
    }


    /**
     * if keys is expired, will return null
     * @param key
     * @return
     */
    public String getStr(String key){
        try {
            RBucket<String> rBucket = redissonClient.getBucket(key);
            return rBucket.get();
        } catch (Exception e) {
            log.error("redisson: getStr error",e);
        }
        return null;
    }


    public Long incrementAndGet(String key, Long second) {
        try {
            RAtomicLong atomicLong = redissonClient.getAtomicLong(key);
            if(second != null){
                atomicLong.expire(second, TimeUnit.SECONDS);
            }
            return atomicLong.incrementAndGet();
        } catch (Exception e) {
            log.error("redisson: incrementAndGet error",e);
        }
        return null;
    }

    public Integer getInteger(String key){
        try {
            RBucket<Integer> rBucket = redissonClient.getBucket(key);
            return rBucket.get();
        } catch (Exception e) {
            log.error("redisson: getInteger error",e);
        }
        return null;
    }


    public Long getLong(String key){
        try {
            RBucket<Long> rBucket = redissonClient.getBucket(key);
            return rBucket.get();
        } catch (Exception e) {
            log.error("redisson: getLong error",e);
        }
        return null;
    }


    public <T> T getEntity(String key){
        try {
            RBucket<T> rBucket = redissonClient.getBucket(key);
            return rBucket.get();
        } catch (Exception e) {
            log.error("redisson: getEntity error",e);
        }
        return null;
    }


    public <T>void addList(String key, List<T> list, Long second){
        try{
            RList<T> rList = redissonClient.getList(key);
            if(!rList.isEmpty()){
                rList.clear();
            }
            if(second != null){
                rList.expire(second, TimeUnit.SECONDS);
            }
            rList.addAll(list);
        } catch (Exception e) {
            log.error("redisson: addList error",e);
        }
    }

    public <T>void appendList(String key, T t, Long second){
        try{
            RList<T> rList = redissonClient.getList(key);
            if(second != null){
                rList.expire(second, TimeUnit.SECONDS);
            }
            rList.add(t);
        } catch (Exception e) {
            log.error("redisson: appendList error",e);
        }
    }

    public <T> List<T> findList(String key){
        try {
            RList<T> rList = redissonClient.getList(key);
            return rList.readAll();
        } catch (Exception e) {
            log.error("redisson: findList error",e);
        }
        return null;
    }


    public <T> void delEntity(String key){
        try {
            RBucket<T> rBucket = redissonClient.getBucket(key);
            rBucket.delete();
        } catch (Exception e) {
            log.error("redisson: delEntity error",e);
        }
    }

    public <T> void delList(String key) {
        try {
            RList<T> rList = redissonClient.getList(key);
            rList.delete();
        }catch (Exception e) {
            log.error("redisson: delList error", e);
        }
    }


    /**
     *
     * @param key
     * @param map Double 代表分数，用于排序。用户自己设置分数，如：以创建时间作为分数等
     */
    public void addOne2ManyWithScore(String key, Map<String, Double> map, Long second){
        try {
            RScoredSortedSet<String> sortedSet = redissonClient.getScoredSortedSet(key);
            if(second != null){
                sortedSet.expire(second, TimeUnit.SECONDS);
            }
            sortedSet.addAll(map);
        } catch (Exception e) {
            log.error("redisson: addOne2ManyWithScore error",e);
        }
    }


    public List<String> findOne2ManySortedByScore(String key, boolean asc){
        try {
            RScoredSortedSet<String> sortedSet = redissonClient.getScoredSortedSet(key);
            int size = sortedSet.size();
            if(size == 0){
                return null;
            }
            if(asc){
                return (List<String>) sortedSet.valueRange(0, size);
            }else{
                return (List<String>) sortedSet.valueRangeReversed(0, size);
            }
        } catch (Exception e) {
            log.error("redisson: findOne2ManySortedByScore error",e);
        }
        return null;
    }


    public RLock acquireDistLock(String lockName) {
        return redissonClient.getLock(lockName);
    }



    public void close() {
        log.info("shutdown redis");
        EventLoopGroup eventLoopGroup = redissonClient.getConfig().getEventLoopGroup();
        if (eventLoopGroup != null) {
            eventLoopGroup.shutdownGracefully();
        }
        redissonClient.shutdown();
    }

}
