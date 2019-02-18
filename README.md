# ParkingService 

Tech Stack : SpringBoot Application,REST,SOAP, for InMemory DB simulation HashMap ,Jackson for JSON generation,UniRest for soap request.

There are two application:-
  1. ParkingLotSystem : Primarily used for parking vehicle as per their spot requirement and availble spot on Level -> ParkingSpot
                       > It first get the parking request(#vehicleNumber), and access the VIS service for vehicle Information like 
                       vehicle name,type(CAR,BIKE,BUS,etc..),color and etc.
                       > On the basis of Vehicle spot requirement it park velhicle on avaiale Level-> Parking Spot.
  2. VIS :it's Vehicle Information Systen and server the vehicle information on the basis of #vehicleNumber and it's developed to provide           SOAP service
  
  
  
  Sample JSON REQUESTS/RESPONSES are mentioned below:-
  
  1. Vehicle Park Request
              URL: http://localhost:8080/pls/park/
              Request Method: POST
              Request Body: {"vehicleNumber":"CAR-0002"}
              
              Response:
              {"vehicleNumber":"CAR-0001","parkingStatus":"P","parkingLocation":"L0R0S0|L0R0S1","message":"Successfuly parked!"}
              
              
 
  2. Vehicle Unpark Park Request
              URL: http://localhost:8080/pls/unpark/
              Request Method: POST
              Request Body: {"vehicleNumber":"CAR-0002"}
              
              Response: 
              {"vehicleNumber":"CAR-0002","parkingStatus":"VNA","parkingLocation":null,"message":"Vehicle Not Available"}
              
              
   3. Vehicle Information (VIS)-> SOAP REQ./RES. format
               ---------------------Request Payload--------------------------
               <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://ws.vis.com/">
                <soapenv:Header/>
                 <soapenv:Body>
                    <ws:getVehicleDetails>
                       <!--Optional:-->
                       <arg0>CAR-0005</arg0>
                    </ws:getVehicleDetails>
                 </soapenv:Body>
              </soapenv:Envelope>
              ------------------Response Payload-------------------------------
              <?xml version="1.0" ?>
            <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                <S:Body>
                    <ns2:getVehicleDetailsResponse xmlns:ns2="http://ws.vis.com/">
                        <return>{"number":"CAR-0005","vehicleType":"CAR","color":"WHITE","name":"RENAULT DUSTER"}</return>
                    </ns2:getVehicleDetailsResponse>
                </S:Body>
            </S:Envelope>
   
              
