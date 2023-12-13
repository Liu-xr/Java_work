// 响应课程目标
function showObjective(){
	$.post("ShowInfoServlet",function(data){
		const objectiveInfo = $.parseJSON(data);
		var i = 1;
		$(objectiveInfo).each(function(index,elem){
			$("#objective"+i).html(elem.objectiveContent);
			i= i+1;
		})
	})
}

// 响应章节内容
function execute($menu){
	var menu = $menu.get(0);
	$.get("ShowInfoServlet", {chapterId:menu.name}, function(data){
		const chapterInfo = $.parseJSON(data);
		$("#chapterid").html(chapterInfo.chapterId);
		$("#chaptername").html(chapterInfo.chapterName);
		$("#studydate").html(chapterInfo.studyDate);
		$("#studytime").html(chapterInfo.studyTime);
		$("#chapterdesc").html(chapterInfo.chapterDesc);
		$("#cid").val(chapterInfo.chapterId);
		$("#div2").show();
	});
}
			