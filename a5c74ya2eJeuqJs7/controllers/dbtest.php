<?php if (!defined('BASEPATH')) exit('No direct script access allowed');

class Dbtest extends CI_Controller
{
	function __construct()
	{
		parent::__construct();

		}

	function index()
	{
		$this->load->database();
		$this->load->model("Patients");
		//$data['patients'] = $this->Patients->get_Patients();
		$results = $this->Patients->get_Patients();
		echo json_encode($results[0]);
		//$this->load->view("dbview.php", $data);
		
		
	}
	
	function callPatientCheck(){
		if (isset($_REQUEST["firstName"]) && isset($_REQUEST["lastName"])
				&& isset($_REQUEST["date"])) {
			$this->load->database();
			$this->load->model("Patients");
			$first = $_REQUEST["firstName"];
			$last =  $_REQUEST["lastName"];
			$dat = $_REQUEST["date"];
			echo $this->Patients->check_Patient($first, $last, $dat);
		} else {
			echo "nothing set!";
		}
	}
	
	
	function insertPatient(){
		if (isset($_REQUEST["firstName"]) && isset($_REQUEST["lastName"])
				&& isset($_REQUEST["date"])) {
			$this->load->database();
			$this->load->model("Patients");
			$first = $_REQUEST["firstName"];
			$last =  $_REQUEST["lastName"];
			$dat = $_REQUEST["date"];
			$country = "Nepal";
			echo $this->Patients->insert_Patient($first, $last, $dat, $country);
		} else {
			echo "nothing set!";
		}
	}
	
	function insertPatientMed(){
		
			$this->load->database();
			$this->load->model("Patients");
			$pid = $_REQUEST["piD"];
			$fcomments =  $_REQUEST["fComments"];
			$img = $_REQUEST["imG"];
			$binary = base64_decode($img);
			file_put_contents('newImage.PNG',$binary);
			$gest = $_REQUEST["gesT"];
			$isbleed = $_REQUEST["isBleed"];
			$preb =  $_REQUEST["preB"];
			$diamFet =  $_REQUEST["diamFet"];
			$diamot =  $_REQUEST["diaMot"];
			$fseen =  $_REQUEST["fSeen"];
			echo $this->Patients->insert_Patient_Med($pid, $fcomments, $binary, $preb, $gest, $isbleed, $diamFet, $diamot, $fseen);
		 
	}
	
	function getPatientMed(){
		if(isset($_REQUEST["piD"])){
			$this->load->database();
			$this->load->model("Patients");
			$pid = $_REQUEST["piD"];
			echo $this->Patients->get_Patient_Med($pid);
		} else{
			echo "nothing set!";
		}
	}
	
	
	

}
