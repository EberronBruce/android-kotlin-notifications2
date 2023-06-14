package com.example.android.eggtimernotifications

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

	override fun onMessageReceived(message: RemoteMessage) {
		//super.onMessageReceived(message)
		Log.d(TAG, "From: ${message.from}")
	}

	override fun onNewToken(token: String) {
		Log.d(TAG, "Refreshed token: $token")

		// If you want to send messages to this application instance or
		// manage this apps subscriptions on the server side, send the
		// Instance ID token to your app server.
		sendRegistrationToServer(token)
	}


	private fun sendRegistrationToServer(token: String?) {
		// TODO: Implement this method to send token to your app server.
	}

	companion object {
		private const val TAG = "MyFirebaseMsgService"
	}
}