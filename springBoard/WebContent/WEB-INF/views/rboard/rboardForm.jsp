<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "a.b.c.com.board.vo.BoardVO" %>
<%@ page import = "a.b.c.com.rboard.vo.RboardVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RBOARD : 댓글</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		selectAll();
				
		// 댓글 등록
		$(document).on("click", "#I", function(){
			alert("I >>> : ");
			
			let insertURL = "rboardInsert.j";		
			let method = "POST";
			let dataParam = {
				sbnum: $("#sbnum").val(),
				rsbname: $("#rsbname").val(),
				rsbcontent: $("#rsbcontent").val(),
			};
			dataParam = $("#rboardForm").serialize();
			alert("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: insertURL,
				type: method,
				data: dataParam,
				success: whenSuccess,
				error: whenError
			});
			
			function whenSuccess(resData){	
				alert("resData >>> : " + resData);				
			}
			function whenError(e){
				alert("e >>> : " + e.responseText);
			}
		});
		
		// 단건 조회
		$(document).on("click", "#S", function(){
			alert("S >>> : ");
			
			let selectURL = "rboardSelect.j";
			let method = "POST";
			let dataParam = {
				rsbnum: $("#rsbnum").val(),				
			};
			// dataParam = $("#jsonTestForm").serialize();
			alert("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: selectURL,
				type: method,
				data: dataParam,
				success: whenSuccess,
				error: whenError
			});
			
			function whenSuccess(resData){	
				alert("resData >>> : " + resData);
				let v = resData.split(",");
				for(let i=0; i < v.length; i++){
					console.log("v[0]" + v[0]);
					console.log("v[1]" + v[1]);
					console.log("v[2]" + v[2]);
					console.log("v[3]" + v[3]);
					addNewItem(v[0], v[1], v[2], v[3]);
				}
			}
			function whenError(e){
				alert("e >>> : " + e.responseText);
			}
		});			
		
		// 댓글 삭제		
		$(document).on("click", "#D", function(){
			alert("D >>> : ");
			
			let selectURL = "rboardDelete.j";
			let method = "POST";
			let dataParam = {
				rsbnum: $("#rsbnum").val(),				
			};
			// dataParam = $("#jsonTestForm").serialize();
			alert("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: selectURL,
				type: method,
				data: dataParam,
				success: whenSuccess,
				error: whenError
			});
			
			function whenSuccess(resData){	
				alert("resData >>> : " + resData);			
			}
			function whenError(e){
				alert("e >>> : " + e.responseText);
			}
		});
	});
	
	// 게시글 번호로 댓글 전체조회
	function selectAll(){
					
		alert("SALL >>> : ");
		
		let selectAllURL = "rboardSelectAll.j";
		let method = "POST";
		let dataParam = {
			sbnum: $("#sbnum").val(),				
		};		
		// dataParam = $("#jsonTestForm").serialize();
		alert("dataParam >>> : " + dataParam);
		
		$.ajax({
			url: selectAllURL,
			type: method,
			data: dataParam,
			success: whenSuccess,
			error: whenError
		});
		
		function whenSuccess(resData){	
			alert("resData >>> : " + resData);
			let v = resData.split("&");
			for(let i=0; i < v.length; i++){
				console.log(v[i]);
				let vv = v[i].split(",");
				let j=0
				for (; j < vv.length-1; j++){
					console.log("vv[0] >>> : " + vv[0]);
					console.log("vv[1] >>> : " + vv[1]);
					console.log("vv[2] >>> : " + vv[2]);
					console.log("vv[3] >>> : " + vv[3]);					
				}
				addNewItem(vv[0], vv[1], vv[2], vv[3]);
			}
		}
		function whenError(e){
			alert("e >>> : " + e.responseText);
		}	
	}
	
	//새로운 글 화면에 추가	
	function addNewItem(num, writer, content, datetime){
		// 새로운 글이 추가될 li태그 
		var newLi = $("<li>");
		newLi.attr("dataNum", num);
		newLi.addClass("rbmemoItem");
		// 작성자 정보가 지정될 <p> 태그 
		var writerP = $("<p>");
		writerP.addClass("writer");
		// 작성자 정보의 이름 
		var nameSpan = $("<span>");
		nameSpan.addClass("name");
		nameSpan.html(decodeURIComponent(writer) + "님");
		// 작성일시 
		var dateSpan = $("<span>");
		dateSpan.html(" / " + datetime + " ");
		// 삭제 버튼 
		var delInput = $("<input>");
		delInput.attr({"type":"button", "value":"삭제하기"});
		delInput.addClass("deleteBtn");
		// 내용
		var contentP = $("<p>");
		contentP.html(decodeURIComponent(content));
		
		// 조립하기
		writerP.append(nameSpan).append(dateSpan).append(delInput);
		newLi.append(writerP).append(contentP);
		$("#rboardlist").append(newLi);
	}	
	
</script>
</head>
<body>
	RBOARD : 댓글
	<hr>
	<div id="rbwriterdiv">
		<form name="rboardForm" id="rboardForm">
			<table>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="rsbname" id="rsbname" /> <input
						type="button" value="저장하기" id="I"></td>
				</tr>
				<tr>
					<td>덧글 내용</td>
					<td><textarea name="rsbcontent" id="rsbcontent" rows="5"
							cols="50" style="resize: none">
						</textarea>
						<div>
							<span class="bytes">0</span>bytes
						</div>
					</td>
				</tr>
			</table>
			<hr>
			<ul name="rboardlist" id="rboardlist">
				<!-- 여기에 동적 생성 요소가 들어온다. -->
			</ul>
		</form>
	</div>
</body>
</html>