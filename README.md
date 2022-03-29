# sms-credit-system
This system allows user to buy  sms credit and processes accordingly

#Required DB scrits:
create database sms;

#sample create user json request body:
end point:
/api/phoneUser/

 {
	"phoneNumber":944320202,
	"userName":"Tony_spark",
	"creditFlag":true
}
#create Purchase:

end point :
/api/phoneUSer/944320202
