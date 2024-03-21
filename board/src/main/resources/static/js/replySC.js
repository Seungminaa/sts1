var replyService = (function() {

//댓글 등록
function listReq(p,b) {
	const param = "?page=" + p + "&bno=" + b
	
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
	
	//단건조회입력
	const btn = document.querySelectorAll('.infoReply');
	for (const button of btn) {
		button.addEventListener("click",e => {
			frm2.reply.value = e.target.closest('tr').childNodes[3].textContent;
			frm2.replyer.value = e.target.closest('tr').childNodes[5].textContent;
			frm2.rno.value = e.target.closest('tr').childNodes[1].textContent;
		})
	}
	
	//댓글 삭제
	for (const button of btn) {
		button.addEventListener("click",e => {
			let no = e.target.closest('tr').childNodes[1].textContent;
			let b = 0;
			if(res.data.length >0){
				b = res.data[0].bno
			}
			removeReq(no,b);
		})
	}
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
		<tr class="infoReply">
			<td>${obj.rno}</td>
			<td>${obj.reply}</td>
			<td>${obj.replyer}</td>
			<td>${dateFormat(obj.replyDate)}</td>
			<td>${dateFormat(obj.updateDate)}</td>
			<td><button type="button" id="remove">삭제</button></td>
		</tr>`
	
	return newTag;
}

//날짜format
function dateFormat(dt) {
		let date = new Date(dt);
		
		let year = date.getFullYear();
		let month = ( 1 + date.getMonth() );
		let day = date.getDate();
		
		month = month >= 10 ? month : '0' + month; //10미만일 시 앞에 0을 붙혀서 저장
		day = day >= 10 ? day : '0' + day;
		
		return `${year}/${month}/${day}`;
}
	
//상세조회
function infoReq(reply,replyer) {
	frm2.reply.value = reply;
	frm2.replyer.value = replyer;
}

//댓글 등록버튼
function saveReq() {
	let param = new FormData(document.frm2);
	fetch("/ajax/reply", {
		method : "post",
		body : param	
	})
	.then(res => res.json())
	.then(res => saveRes(res))
}

//등록 응답
function saveRes(res) {
	listReq(1,res.bno);
}

//댓글 수정버튼
function updateReq() {
	let param = new FormData(document.frm2);
	fetch("/ajax/update", {
		method : "post",
		body : param	
	})
	.then(res => res.json())
	.then(res => saveRes(res))
}

//댓글 삭제버튼
function removeReq(no,b) {
	const param = "?rno=" + no + "&bno=" + b
	fetch("/ajax/delete" + param, {
		method : "get"
	})
	.then(res => res.json())
	.then(res => saveRes(res))
}


return { infoReq, saveReq, listReq, updateReq }
})();