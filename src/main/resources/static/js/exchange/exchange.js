$(function() {
    getExchangeInfo("20231108");
})
/**
 *  햄버거 버튼 클릭시 사이드바 존재여부 따라 테이블 넓이 조절
 * */
function control_width() {
    if(document.querySelector('body').classList.contains('toggle-sidebar')) {
        // document.querySelector('.ex_table').style.width = 'calc(100% - 300px)';
        document.querySelector('.ex_table').style.width = '100%';
    } else {
        // document.querySelector('.ex_table').style.width = '100%';
        document.querySelector('.ex_table').style.width = 'calc(100% - 300px)';
    }
}

/**
 *  ajax 환율 API호출
 *  PARAM : DATE(날짜) / 기본값 : 오늘날짜
 * */
function getExchangeInfo(DATE) {
    let param = { DATE: DATE };

    $.ajax({
        url: "/api/exchange/list", // 클라이언트가 요청을 보낼 서버의 URL 주소
        data: {"dt" : DATE},             // HTTP 요청과 함께 서버로 보낼 데이터
        type: "GET",                             // HTTP 요청 방식(GET, POST)
        dataType: "json"                         // 서버에서 보내줄 데이터의 타입
    })
    // HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
    .done(function(arr) {
        if(arr.length < 1) {
            return;
        }
        $.each(arr, function (i, item) {
            if(item.cur_unit != "KRW") {
                let tr = $("<tr/>");
                let td1 = "<td style='text-align:left;'>";
                td1 += "<img style='margin-right:10px;' src='/img/country/" + item.cur_unit + ".png'" + "/>";
                td1 += item.cur_unit + "&nbsp;&nbsp;&nbsp;" + item.cur_nm + "</td>";
                tr.append(td1);
                let td2 = "<td>" + item.deal_bas_r + "</td>";
                tr.append(td2);
                let td3 = "<td>" + item.tts + "</td>";
                tr.append(td3);
                let td4 = "<td>" + item.ttb + "</td>";
                tr.append(td4);
                $("#ex_body").append(tr);
            }
        })
    })
    // HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.
    .fail(function(xhr, status, errorThrown) {
        let msg = '';
        msg += '오류명 : ' + errorThrown;
        msg += ', 상태 : ' + status;
        alert(msg);
    })
}

export {control_width};