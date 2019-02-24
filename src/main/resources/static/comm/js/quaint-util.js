//测试使用
// $(function(){
//     var abc = '2015-11-20 " 12:00:12\r\n 12356';
//     alert(abc);
//     alert(safeJson(abc));
// })

//防止json注入(测试失败) 已用JSON.stringify() 解决
function safeJson(jsonStr){
    return jsonStr.replace(/:|"|\r\n/g, function (a) {
        switch (a) {
            case ':':
                return '\\:';
                break;
            case '"':
                return '\\"';
                break;
            case '\r\n':
                return '\\r\\n';
                break;
        }
    })
}
//封装时间格式  ${format(moods[i].moodTime,'yyyy-MM-dd HH:mm:ss')}
// ios 显示异常，已被注解替代
function format(time, format) {
    var t = new Date(time);
    var tf = function (i) {
        return (i < 10 ? '0' : '') + i
    };
    return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function (a) {
        switch (a) {
            case 'yyyy':
                return tf(t.getFullYear());
                break;
            case 'MM':
                return tf(t.getMonth() + 1);
                break;
            case 'mm':
                return tf(t.getMinutes());
                break;
            case 'dd':
                return tf(t.getDate());
                break;
            case 'HH':
                return tf(t.getHours());
                break;
            case 'ss':
                return tf(t.getSeconds());
                break;
        }
    })
}