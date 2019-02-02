$(function(){
    /* 鼠标特效 */
    var a_idx = 0;
    jQuery(document).ready(function($) {
        $("body").click(function(e) {
            var a = new Array(
                "❤生命的真谛深邃而迷人--Quaint❤",
                "❤愿大家能够吃饱穿暖--赵云❤",
                "❤我已经无心敲代码了--张震❤",
                "❤我的心已经飞向了外面的世界--张震❤",
                "❤我见众生皆草木,唯你是青山--周娜❤",
                "❤愿你出来半生，归来仍是少年--李航❤",
                "❤带着我的意志活下去--李航❤",
                "❤没尝试过就很向往--郭鹏鹏❤",
                "❤抹除了你这一年的记忆，希望这次你能好好珍惜--郭鹏鹏❤",
                "❤愿你有前进一寸的勇气，亦有后退一尺的从容--郭鹏鹏❤",
                "❤摔倒就停下来了--李吉亮❤"
            );
            var $i = $("<span></span>").text(a[a_idx]);
            a_idx = (a_idx + 1) % a.length;
            var x = e.pageX,
                y = e.pageY;
            $i.css({
                "z-index": 999999999999999999999999999999999999999999999999999999999999999999999,
                "top": y - 20,
                "left": x,
                "position": "absolute",
                "font-weight": "bold",
                "color": "rgb("+~~(255*Math.random())+","+~~(255*Math.random())+","+~~(255*Math.random())+")"
            });
            $("body").append($i);
            $i.animate({
                    "top": y - 180,
                    "opacity": 0
                },
                1500,
                function() {
                    $i.remove();
                });
        });
    });
})