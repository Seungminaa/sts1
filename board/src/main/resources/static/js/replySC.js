var replyService = (function() {

//댓글 등록
function listReq(p) {
	const param = "?page=" + p + "&bno=" + [[${board.boardNo}]]
	
	//댓글리스트 받아오기
	axios.get("/ajax/rList" + param)
	.then(res => listRes(res.data));
}

//댓글 페이지 및 목록만들기
function listRes(res) {
		
	let i=0; // NO.
	//목록출력
	replyList.innerHTML = '';
	
	for(repObj of res.data) {
		replyList.innerHTML += makeTr(++i, repObj);
	}
	
	//페이징처리
	nav.innerHTML = makePage(res.paging)
	
}

//페이징
function makePage(paging) {
	let tag = `<nav aria-label="...">
		  <ul id="ust">`
	//이전버튼
	if(paging.startPage > 1) {
		tag += `<li> 
	        <a class="page-link" href="javascript:gopage(${paging.startPage-1})">Previous</a></li>`
	}
	//페이지번호	  
	for(num=paging.startPage; num <= paging.endPage; num++) {
		tag += `<li>
	        <a class="page-link" href="javascript:gopage(${num})">${num}</a></li>`
	}
	//다음버튼
	if(paging.endPage < paging.lastPage) {
		tag += `<li>
	        <a class="page-link" href="javascript:gopage(${paging.endPage+1})">Next</a></li>`
	}
	tag += `</ul>
		</nav>`
	return tag;
}

//댓글목록 tr
function makeTr(i, obj) {
		
	//table body 삽입
	let newTag = `
		<tr th:onclick="infoReq([[${obj.reply}]])">
			<td>${i}</td>
			<td>${obj.reply}</td>
			<td>${obj.replyer}</td>
			<td>${dateFormat(obj.replyDate)}</td>
			<td>${dateFormat(obj.updateDate)}</td>
		</tr>`
	return newTag;
}

//날짜format
function dateFormat(dt) {
		console.log(dt);
		let date = new Date(dt);
		
		let year = date.getFullYear();
		let month = ( 1 + date.getMonth() );
		let day = date.getDate();
		
		month = month >= 10 ? month : '0' + month; //10미만일 시 앞에 0을 붙혀서 저장
		day = day >= 10 ? day : '0' + day;
		
		return `${year}/${month}/${day}`;
}
	
//상세조회
function infoReq(reply) {
	frm.reply.value = reply;
}

//등록버튼
function saveReq() {
	let param = new FormData(document.frm);
	fetch("/ajax/reply", {
		method : "post",
		body : param	
	})
	.then(res => res.json())
	.then(res => saveRes(res))
}

//등록 응답
function saveRes(res) {
	listReq(1);
}


return { infoReq, saveReq, listReq }
})();