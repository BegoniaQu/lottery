var required = function (value) {
    value = $.trim(value);
    if (!value) {
        return '这是必填项';
    }
}