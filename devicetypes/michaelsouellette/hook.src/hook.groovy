/**
 *  Copyright 2015 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
	definition (name: "${textDevName()}", namespace: "michaelsouellette", author: "BeckyR, MichaelOuellette") {
		capability "Switch"
	}


	// tile definitions
	tiles {
		standardTile("switch", "device.switch", width: 2, height: 2, canChangeIcon: true) {
			state "on", label: '${name}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#00a0dc"
			state "off", label: '${name}', action: "switch.on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
		}

		main "switch"
		details "switch"
	}
}


def on() {
	put('On')
}

def off() {
	put('Off')
}

private put(toggle) {
    def deviceIds = device.deviceNetworkId.split(',')
	def params = [
    uri: "https://api.gethook.io/v1/device/trigger/${deviceIds[1]}/${toggle}/?token=${deviceIds[0]}"
]
    httpGet(params)
}
