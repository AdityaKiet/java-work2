function deleteConfirm(id){
	$.ajax({  
		type: "GET", //The type of HTTP method (post, get, etc)  
		url: "DeleteRequest?id="+id, //The URL from the form element where the AJAX request will be sent  
		dataType: "json", //The type of response to expect from the server  
		success: function ( data, statusCode, xhr ) { //Triggered after a successful response from server  
			loadRequest();
		},  
		error: function ( xhr, errorType, exception ) { //Triggered if an error communicating with server  
			loadRequest();
		} 
	}); // Ajax close
	}
	

function loadRequest(){
	$('#requests').dataTable({
		"bAutoWidth" : false,
		"bPagination":true,
		"bProcessing": true,
		"bServerSide": true,
		"bSort":false,
		"bDestroy": true,
		"sAjaxSource": "GetRequests",
		"bJQueryUI" : true,
		"aoColumnDefs": [
		                 {
		                	 "aTargets": [ 5 ], // Column to target
		                	 "mRender": function ( data, type, full ) {
		                		 // 'full' is the row's data object, and 'data' is this column's data
		                		 // e.g. 'full[0]' is the comic id, and 'data' is the comic title
		                		 return '<p ><button onclick="deleteConfirm(\''+full.id+'\')" class="btn btn-danger btn-xs" data-title="Delete"><span class="glyphicon glyphicon-ok-sign"></span></button></p>';
		                	 }
		                 }
		                 ],

		                 "aoColumns": [
		                               { "mData": "mob_no" },
		                               { "mData": "imei" },
		                               {"mData":  "latitude"},
		                               { "mData": "longitude"},
		                               {"mData":"address"}
		                               ],
		                               "oLanguage": {
		                            	   "sLengthMenu": "Display _MENU_ records per page",
		                            	   "sZeroRecords": "Nothing found - sorry",
		                            	   "sInfo": "Showing _START_ to _END_ of _TOTAL_ records",
		                            	   "sInfoEmpty": "Showing 0 to 0 of 0 records",
		                            	   "sInfoFiltered": "(filtered from _MAX_ total records)"
		                               },
		                               "sDom": 'T<"clear">lfrtip' ,

		                               "oTableTools": {
		                            	   "aButtons": [
		                            	                {
		                            	                	"sExtends":    "collection",
		                            	                	"sButtonText": "Save",
		                            	                	"aButtons":    [ "csv", "xls", "pdf" ]
		                            	                }
		                            	                ],
		                            	                "sSwfPath": "../extras/TableTools/media/swf/copy_csv_xls_pdf.swf"
		                               }  
	});
	$('div.dataTables_filter input').attr("placeholder", "by mobile no");
}


function loadUsers(){
	$('#user').dataTable({
		"bAutoWidth" : false,
		"bPagination":true,
		"bProcessing": true,
		"bServerSide": true,
		"bSort":false,
		"bDestroy": true,
		"sAjaxSource": "GetUsers",
		"bJQueryUI" : true,

		                 "aoColumns": [
		                               { "mData": "name" },
		                               { "mData": "mobNo" },
		                               {"mData":  "parentMobNo"},
		                               { "mData": "voterId"},
		                               {"mData":"imei"},
		                               {"mData":"postalCode"},
		                               {"mData":"email"},
		                               {"mData":"address"}
		                               ],
		                               "oLanguage": {
		                            	   "sLengthMenu": "Display _MENU_ records per page",
		                            	   "sZeroRecords": "Nothing found - sorry",
		                            	   "sInfo": "Showing _START_ to _END_ of _TOTAL_ records",
		                            	   "sInfoEmpty": "Showing 0 to 0 of 0 records",
		                            	   "sInfoFiltered": "(filtered from _MAX_ total records)"
		                               },
		                               "sDom": 'T<"clear">lfrtip' ,

		                               "oTableTools": {
		                            	   "aButtons": [
		                            	                {
		                            	                	"sExtends":    "collection",
		                            	                	"sButtonText": "Save",
		                            	                	"aButtons":    [ "csv", "xls", "pdf" ]
		                            	                }
		                            	                ],
		                            	                "sSwfPath": "../extras/TableTools/media/swf/copy_csv_xls_pdf.swf"
		                               }  
	});
	$('div.dataTables_filter input').attr("placeholder", "by name");
}

$(document).ready(function() {

	loadRequest();
	loadUsers();

} );