var konfigApp = angular.module("konfigApp", ['ngRoute']);

konfigApp.config(['$routeProvider', function ($routeProvider){
	$routeProvider.when('/', {
		templateUrl: '/static/app/html/index.html'
		}).when('/konfiguracije', {
		templateUrl: '/static/app/html/partial/konfiguracije.html'
		}).when('/konfiguracije/edit/:id', {
	    templateUrl: '/static/app/html/partial/editKonfiguracije.html'
		}).otherwise({
        redirectTo: '/'
    });

}]);


konfigApp.controller("konfiguracijeCTRL", function($scope, $http, $location){

	var base_url_konfiguracije = "/api/konfiguracije";
	
	var base_url_modeli_poProizvodjacu = "/api/proizvodjaci/";

	var base_url_proizvodjaci = "/api/proizvodjaci";
	var base_url_modeli = "/api/modeli";

	$scope.konfiguracije = [];
	$scope.proizvodjaci = [];
	$scope.modeli = [];
	$scope.modeliPoProizvodjacu = [];
	

	$scope.newKonfiguracija = {};
	$scope.newKonfiguracija.modelId = "";
	$scope.newKonfiguracija.proizvodjacId = "";
	$scope.newKonfiguracija.ram = "";
	$scope.newKonfiguracija.cena = "";


	$scope.wantedKonfig = {};
	$scope.wantedKonfig.modelNaziv = "";
	$scope.wantedKonfig.minCena = "";
	$scope.wantedKonfig.maxCena = "";
	$scope.wantedKonfig.minRam = "";
	$scope.wantedKonfig.maxRam = "";

	$scope.konfiguracija = {};
	$scope.konfiguracija.modelId = "";
	$scope.konfiguracija.proizvodjacId = "";
	$scope.konfiguracija.ram = "";
	$scope.konfiguracija.cena = "";

	$scope.pageNum = 0;
	$scope.totalPages = 0;

	var getKonfiguracije = function(){

		var config = {params: {}};
		config.params.pageNum = $scope.pageNum;

		if($scope.wantedKonfig.modelNaziv != ""){
			config.params.modelNaziv = $scope.wantedKonfig.modelNaziv;
		}
		if($scope.wantedKonfig.minCena != ""){
			config.params.minCena =$scope.wantedKonfig.minCena; 
		}
		if($scope.wantedKonfig.maxCena != ""){
			config.params.maxCena = $scope.wantedKonfig.maxCena;
		}

		if($scope.wantedKonfig.minRam != ""){
			config.params.minRAM = $scope.wantedKonfig.minRam;
		}
		if($scope.wantedKonfig.maxRam != ""){
			config.params.maxRAM = $scope.wantedKonfig.maxRam;
		}

		$http.get(base_url_konfiguracije, config)
		.then(
			function succes(data){
				$scope.konfiguracije=data.data;
				$scope.totalPages = data.headers("totalPages");
				console.log($scope.totalPages);
			});

	};
	var getProizvodjaci = function(){
		$http.get(base_url_proizvodjaci)
		.then(function success (data){
			$scope.proizvodjaci = data.data;
		});
	};
	var getModeli = function(){
		$http.get(base_url_modeli)
		.then(function success (data){
			$scope.modeli = data.data;
		});
	};


	getKonfiguracije();
	getProizvodjaci();
	getModeli();


	$scope.getModelePoProizvodjacu = function(proizvodjacId){
		$http.get(base_url_modeli_poProizvodjacu  + proizvodjacId + "/modeli")
		.then(function success (data){
			$scope.modeliPoProizvodjacu = data.data;
		});
	};
	


	$scope.addKonfiguracija = function(){
		var found = false;
		for(var i = 0; i < $scope.konfiguracije.length; i++) {
	    		if ($scope.konfiguracije[i].id == $scope.newKonfiguracija.id) {
	       			found = true;
	    	        break;
	    		}
		}
		if(!found){
			$http.put(base_url_konfiguracije + "/" + $scope.newKonfiguracija.id, $scope.newKonfiguracija)
					.then(
						function success(data){

						alert('Konfiguracija je uspesno izmenjena!');
					});
		}else{
			$http.post(base_url_konfiguracije, $scope.newKonfiguracija)
			.then(function success(data){
				console.log(data.data);
				alert('Uspesno ste dodali konfiguraciju!');
				
					});

				}

		getKonfiguracije();	
		$scope.newKonfiguracija.id=0;
		$scope.newKonfiguracija.modelId = "";
		$scope.newKonfiguracija.proizvodjacId = "";
		$scope.newKonfiguracija.ram = "";
		$scope.newKonfiguracija.cena = "";
		

	};

	$scope.obrisi = function(id){
		$http.delete(base_url_konfiguracije + "/" + id)
		.then(
			function success(data){
				getKonfiguracije();
			},
			function error(data){
				alert('Neuspesno brisanje!');
				console.log(data);
			});
	}

	$scope.trazi = function(){
		$scope.pageNum = 0;
		getKonfiguracije();
	}

	$scope.changePage = function(num){
        $scope.pageNum = $scope.pageNum + num;
        getKonfiguracije();

    }
    $scope.izmeniNaDrugojStr = function(id){
		$location.path("/konfiguracije/edit/" + id);
	}

	var getKonfiguracija = function(id){
			$http.get(base_url_konfiguracije + "/" + id)
			.then(
				function success (data){
					$scope.konfiguracija = data.data;

				});
		}
	$scope.ubaciObjekat = function(id){
		getKonfiguracija(id);
		$scope.newKonfiguracija.id = id;
		$scope.newKonfiguracija.modelId = $scope.konfiguracija.modelId;
		$scope.newKonfiguracija.proizvodjacId = $scope.konfiguracija.proizvodjacId;
		$scope.newKonfiguracija.ram = $scope.konfiguracija.ram;
		$scope.newKonfiguracija.cena = $scope.konfiguracija.cena;

	}

});

konfigApp.controller("editKonfiguracijeCTRL", function($scope, $http, $location, $routeParams){
	var base_url_konfiguracije = "/api/konfiguracije";
	var base_url_proizvodjaci = "/api/proizvodjaci";
	var base_url_modeli = "/api/modeli";
	var base_url_modeli_poProizvodjacu = "/api/proizvodjaci/";
	var id = $routeParams.id;
	
	$scope.konfiguracija = {};
	$scope.konfiguracija.modelId = "";
	$scope.konfiguracija.proizvodjacId = "";
	$scope.konfiguracija.ram = "";
	$scope.konfiguracija.cena = "";

	$scope.proizvodjaci = [];
	$scope.modeli = [];

	var getKonfiguracija = function(){
			$http.get(base_url_konfiguracije + "/" + id)
			.then(
				function success (data){
					$scope.konfiguracija = data.data;

				});
		}
	var getProizvodjaci = function(){
		$http.get(base_url_proizvodjaci)
		.then(function success (data){
			$scope.proizvodjaci = data.data;
		});
	};
	var getModeli = function(){
		$http.get(base_url_modeli)
		.then(function success (data){
			$scope.modeli = data.data;
		});
	};
		getKonfiguracija();
		getProizvodjaci();
		getModeli();

		$scope.getModelePoProizvodjacu = function(proizvodjacId){
		$http.get(base_url_modeli_poProizvodjacu  + proizvodjacId + "/modeli")
		.then(function success (data){
			$scope.modeliPoProizvodjacu = data.data;
		});
	};




	$scope.izmeni = function(){
		$http.put(base_url_konfiguracije + "/" + id, $scope.konfiguracija)
		.then(
			function success(data){

				alert('Konfiguracija je uspesno izmenjena!');
				$location.path("/konfiguracije");
			});
	}




	});