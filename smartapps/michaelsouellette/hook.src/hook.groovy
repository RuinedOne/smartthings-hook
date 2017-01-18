/********************************************************************************************
|    Application Name: Hook Manager                                                         |
|    Author: michaelsouellette                                                              |
|                                                                                           |
|                                                                                           |
|                                                                                           |
|*******************************************************************************************|
|    There maybe portions of the code that may resemble code from other apps in the         |
|    community. I may have used some of it as a point of reference.                         |
|    Thanks go out to those Authors!!!                                                      |
|    I apologize if i've missed anyone.  Please let me know and I will add your credits     |
|                                                                                           |
|    ### I really hope that we don't have a ton or forks being released to the community,   |
|    ### I hope that we can collaborate and make app and device type that will accommodate  |
|    ### every use case                                                                     |
*********************************************************************************************/

import groovy.json.*

definition(
	name: "${textAppName()}",
	namespace: "${textNamespace()}",
	author: "${textAuthor()}",
	description: "${textDesc()}",
	category: "Convenience",
	iconUrl: "https://raw.githubusercontent.com/tonesto7/nest-manager/master/Images/App/nest_manager.png",
	iconX2Url: "https://raw.githubusercontent.com/tonesto7/nest-manager/master/Images/App/nest_manager%402x.png",
	iconX3Url: "https://raw.githubusercontent.com/tonesto7/nest-manager/master/Images/App/nest_manager%403x.png",
	singleInstance: true,
	oauth: true )

{
	appSetting "clientId"
	appSetting "clientSecret"
	appSetting "devOpt"
}

include 'asynchttp_v1'

def appVersion() { "0.1" }
def appVerDate() { "12-28-2016" }
def appVerInfo() {
	def str = ""

	str += "V0.1 (December 28th, 2016):"
	str += "\n▔▔▔▔▔▔▔▔▔▔▔"
	str += "\n Basic setup"
	return str
}


preferences {
	//startPage
	page(name: "startPage")
}


/******************************************************************************
|					Application Pages						 				  |
*******************************************************************************/
//This Page is used to load either parent or child app interface code
def startPage() {
	if(parent) {
		atomicState?.isParent = false
		selectAutoPage()
	} else {
		atomicState?.isParent = true
		authPage()
	}
}
