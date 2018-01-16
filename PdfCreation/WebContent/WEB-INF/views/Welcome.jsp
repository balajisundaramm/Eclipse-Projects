<!DOCTYPE html>
<html lang="en">
<head>
	<title>CandidateForm</title>

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

	<!-- Latest compiled JavaScript -->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="preview.js"></script>
	<script type="text/javascript" src="loader.js"></script>
	<script type="text/javascript" src="piechart.js"></script>
	<script type="text/javascript">
	function preview(element) {
		if (element.files && element.files[0]) {
			var reader = new FileReader();
			reader.onload = imageIsLoaded;
			reader.readAsDataURL(element.files[0]);
		}
	};
	function imageIsLoaded(e) {
		$("#myImg").attr('src', e.target.result);
		sessionStorage.setItem("myImg",e.target.result);
		$("#myImg").val("1");
	};
	function assignValue(item,here){
		var val = item.value;
		sessionStorage.setItem(item.id, val);
		if (item.id=="resume"||item.id=="linkedin"||item.id=="video") {$('#'+here).attr('href',val).html(item.id+' url')}
				else{
		$('#'+here).html(val);
		$('#'+here).val(val);
	}
	};
	$(document).ready(function(){
		if (sessionStorage.getItem('isSessionOn')=="true") {
			$('#Name').val(sessionStorage.getItem('Name'));$('#Email').val(sessionStorage.getItem('Email'));$('#Mobile').val(sessionStorage.getItem('Mobile'));
			$('#JobTitle').val(sessionStorage.getItem('JobTitle'));$('#Loc').val(sessionStorage.getItem('Loc'));$('#Location').val(sessionStorage.getItem('Location'));
			$('#Salary').val(sessionStorage.getItem('Salary'));$('#Technical\\ Experience').val(sessionStorage.getItem('Technical Experience'));$('#Project\\ Experience').val(sessionStorage.getItem('Project Experience'));
			$('#Stable\\ Work\\ History').val(sessionStorage.getItem('Stable Work History'));$('#pos1').val(sessionStorage.getItem('pos1'));$('#pos2').val(sessionStorage.getItem('pos2'));
			$('#pos3').val(sessionStorage.getItem('pos3'));$('#conc1').val(sessionStorage.getItem('conc1'));$('#conc2').val(sessionStorage.getItem('conc2'));
			$('#conc3').val(sessionStorage.getItem('conc3'));$('#comment').val(sessionStorage.getItem('comment'));$('#resume').val(sessionStorage.getItem('resume'));$('#video').val(sessionStorage.getItem('video'));$('#linkedin').val(sessionStorage.getItem('linkedin'));
			$("#myImg").attr('src', sessionStorage.getItem('myImg'));
			if (sessionStorage.getItem("pdfSaved")) {
				$('#section-2').show();
				window.scrollTo(0, 50000);
				sessionStorage.setItem("pdfSaved","false");
			};
			setTimeout(drawChart, 1000);
			sessionStorage.setItem("isSessionOn","false");

		}
		else{
			sessionStorage.clear();
		}
	});
</script>
<style type="text/css">
[name='previewData']{
	display: none;
}
.footer {
	background-color: #f5f5f5;
}
.text-muted {
	bottom: 0;
}
#footerRebutton{
	color: #777;
}
#footerEric{
	color: #00802b;

}
</style>
</head>
<body id='body'>
	<div class="container">
		<div class='row'><div class="col-sm-12 text-center"><h3>CANDIDATE SCORECARD</h3></div></div>
		<div class="row" id ="header">
			<div class="col-sm-4" style="height: 100px;"><img src="logo.jpg"  height="52" width="182"></div>
			<div class="col-sm-4 text-center" style="height: 100px;">
				<h3 id="previewName" name='previewData'></h3>
				<br>
				<input class="form-control" id="Name" type="text" placeholder="Enter name" onchange='assignValue(this,"previewName")' name='formData'>
			</div>
			<div class="col-sm-4 text-center" style="height: 100px;">
				<input type="image" id="myImg" src="upload.png" class="img-rounded" alt="upload" width="100" height="100" onclick = "$('#uploadImg').click()">
				<input id='uploadImg' type='file' style ="display:none;" onchange="preview(this);" accept="image/*"/>
			</div>
		</div>
		<br>
		<div id ="section-1" class='row'>
			<div class="col-xs-3">
				<div class="alert alert-success text-center" name='previewData' id='job' style="height: 50px;"></div>
				<input class="form-control" id="JobTitle" type="text" placeholder="Enter job title" name='formData' onchange="assignValue(this,'JobTitle')">
			</div>
			<div class="col-xs-3">
				<div class="alert alert-success text-center" name='previewData' id ="location" style="height: 50px;"></div>
				<input class="form-control" id="Loc" type="text" placeholder="Enter location" name='formData' onchange="assignValue(this,'location')">
			</div>
			<div class="col-xs-3">
				<div class="alert alert-success text-center" name='previewData' id ="location" style="height: 50px;"></div>
				<input class="form-control" id="Loc" type="text" placeholder="Gulfstream
Strategic Placements" name='formData' onchange="assignValue(this,'location')">
			</div>
		</div>
		<br><br>
		<div id ='section-3' class='row'>
			<div class="col-sm-3">
				<br name='formData'><br name='formData'>
				<div class="form-group">
					<p id='locScore' class='alert alert-success' name='previewData'></p>
					<select class="form-control" id="Location" name='formData' onchange='assignValue(this,"locScore")'>
						<option value=0> Open to Relocate</option>
						<option data-toggle="tooltip" title="Hooray!">YES</option>
						<option data-toggle="tooltip" title="Hooray!">NO</option>
						<option data-toggle="tooltip" title="Hooray!">MAY BE</option>
						<option data-toggle="tooltip" title="Hooray!">NOT APPLICABLE</option>
						<option data-toggle="tooltip" title="Hooray!">OTHERS</option>
					</select>
				</div>
				<div class="form-group">
					<p id="salaryScore" class='alert alert-success' name='previewData'></p>
					<select class="form-control" id="Salary" name='formData' onchange='assignValue(this,"salaryScore")'>
						<option value=0>Salary Details</option>
						<option data-toggle="tooltip" title="Hooray!">BELOW MARKET</option>
						<option data-toggle="tooltip" title="Hooray!">WITHIN MARKET</option>
						<option data-toggle="tooltip" title="Hooray!">ABOVE MARKET</option>
						<option data-toggle="tooltip" title="Hooray!">NOT APPLICABLE</option>
					</select>
				</div>
			<div class='col-sm-1 col-sm-offset-4'>

			</div>
		</div>
		<br>
		<div id='section-4' class='row'>
			<div class="form-group col-sm-4">
				<label for="usr">Highlights</label>
				<div class='row'>
					<div class='col-sm-1 '>1.</div>
					<div class='col-sm-10'>
						<p id="positive1" name='previewData'></p>
						<input type="text" class="form-control" id="pos1" name='formData' onchange='assignValue(this,"positive1")'>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-1 '>2.</div>
					<div class='col-sm-10'>
						<p id="positive2" name='previewData'></p>
						<input type="text" class="form-control" id="pos2" name='formData' onchange='assignValue(this,"positive2")'>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-1 '>3.</div>
					<div class='col-sm-10'>
						<p id="positive3" name='previewData'></p>
						<input type="text" class="form-control" id="pos3" name='formData' onchange='assignValue(this,"positive3")'>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-1 '>4.</div>
					<div class='col-sm-10'>
						<p id="positive3" name='previewData'></p>
						<input type="text" class="form-control" id="pos3" name='formData' onchange='assignValue(this,"positive3")'>
					</div>
				</div>
				<label for="usr">Concerns:</label>
				<div class='row'>
					<div class='col-sm-1 '>1.</div>
					<div class='col-sm-10'>
						<p id="concern1" name='previewData'></p>
						<input type="text" class="form-control" id="conc1" name='formData' onchange='assignValue(this,"concern1")'>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-1 '>2.</div>
					<div class='col-sm-10'>
						<p id="concern2" name='previewData'></p>
						<input type="text" class="form-control" id="conc2" name='formData' onchange='assignValue(this,"concern2")'>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-1 '>3.</div>
					<div class='col-sm-10'>
						<p id="concern3" name='previewData'></p>
						<input type="text" class="form-control" id="conc3" name='formData' onchange='assignValue(this,"concern3")'>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-1 '>4.</div>
					<div class='col-sm-10'>
						<p id="concern3" name='previewData'></p>
						<input type="text" class="form-control" id="conc3" name='formData' onchange='assignValue(this,"concern3")'>
					</div>
				</div>
			</div>
			<div class="form-group col-sm-4">
				<label for="comment">Candidate Bio</label>
				<p id="commentText" name='previewData'></p>
				<textarea class="form-control" rows="11" id="comment" name='formData' onchange='assignValue(this,"commentText")'></textarea>
			</div>
			<div class="form-group col-sm-4">
				<label for="comment">Reason for Leaving</label>
				<p id="commentText" name='previewData'></p>
				<textarea class="form-control" rows="11" id="comment" name='formData' onchange='assignValue(this,"commentText")'></textarea>
			</div>
			<div id ="section-1" class='row'>
				<div class="col-xs-5">
				<a href style="height: 20px;" class='well well-sm' id='resumeHref' name='previewData'></a>
				<input name='formData' class="form-control" id="resume" placeholder='Resume URL' type="url" onchange="assignValue(this,'resumeHref')"/>
				</div>
				<div class="col-xs-5">
				<a href style="height: 20px;" class='well well-sm' id='videoHref' name='previewData'></a>
				<input name='formData' class="form-control" id="video" placeholder='Video URL' type="url" onchange="assignValue(this,'videoHref')" />
				</div></div>

			</div>
			<div id="editor"></div>
		</div>
		<br>
		<div class='row' style="text-align:center">
			<button type="button" name='formData' class="btn btn-success" onclick='previewForm()'>Preview & Save PDF</button>
			<br><br>
			<img id='load' src="load.gif" style='display:none;'/>
		</div>
		<div style="text-align:center;display:none" id='saveBack'>
			<button id='save' type="button" class="btn btn-success">Save to PDF</button>
			<button type="button" class="btn btn-success" id="back" onclick="window.open('webform.html','_self');">back</button>
			
		</div>
		<br>
		<div id='section-2' style ="display:none;" class='row'>
			<form role="form">
				<div class="col-sm-12 alert alert-warning" id ="job" style="text-align:center">
					<!-- <p name='previewData'></p> -->
					<label style="color:black;">Email Eric Regarding:</label>
					<br>
					<button id='Schedule_Interview' class="btn btn-success" type="button"><a onclick="javascript:window.location='mailto:ERIC@GULFSTREAMSP.COM?Subject=SCHEDULE INTERVIEW: '+document.getElementById('Name').value" style="color:white;">Schedule Interview</a></button>
					<!-- <p name='previewData'></p> -->
					<button id='Present_again_in_30_days' class="btn btn-success" type="button"><a onclick="javascript:window.location='mailto:ERIC@GULFSTREAMSP.COM?Subject=PRESENT AGAIN IN 30 DAYS: '+document.getElementById('Name').value" style="color:white;">Present again in 30 days</a></button>	
					<!-- <p name='previewData'></p> -->
					<button id='Not_Interested' class="btn btn-success" type="button"><a onclick="javascript:window.location='mailto:ERIC@GULFSTREAMSP.COM?Subject=NOT INTERESTED: '+document.getElementById('Name').value" style="color:white;">Not Interested</a></button>
				</div>
			</form>
			<br><br>
			<div class="alert alert-danger text-center" id="Note">
				<strong>Note!</strong> Please don't forget to attach the PDF downloaded while sending mail.
			</div>
		</div>
	</div>
	<footer class="footer" name='formData'>
		<div id="footerRebutton" class="container text-muted text-right">
			Form designed by Rebutton.Co (<a href="http://www.rebutton.co">www.rebutton.co</a>)
		</div>
	</footer>
	<footer class="footer" name='previewData'>
		<div id="footerEric" class="container text-muted text-center" style="color:#00802b;">
			Dickerson | Gulfstream Strategic Placements | (949) 257-9643 | <a href="www.mechanicalrecruiters.com">www.mechanicalrecruiters.com</a> | <a href="eric@gulfstreamsp.com">eric@gulfstreamsp.com</a>
		</div>
	</footer>
</body>
</html>