package com.example.android.eggtimernotifications

import android.app.NotificationManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.android.eggtimernotifications.util.sendNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

	override fun onMessageReceived(message: RemoteMessage) {
		Log.d(TAG, "From: ${message.from}")

		// TODO: Step 3.5 check messages for data
		// Check if message contains a data payload.
		message.data.let {
			Log.d(TAG, "Message data payload: " + message.data)
		}
		// TODO: Step 3.6 check messages for notification and call sendNotification
		// Check if message contains a notification payload.
		message.notification?.let {
			Log.d(TAG, "Message Notification Body: ${it.body}")
			sendNotification(it.body!!)
		}

	}

	override fun onNewToken(token: String) {
		Log.d(TAG, "Refreshed token: $token")

		// If you want to send messages to this application instance or
		// manage this apps subscriptions on the server side, send the
		// Instance ID token to your app server.
		sendRegistrationToServer(token)
	}

	/**
	 * Create and show a simple notification containing the received FCM message.
	 *
	 * @param messageBody FCM message body received.
	 */
	private fun sendNotification(messageBody: String) {
		val notificationManager = ContextCompat.getSystemService(applicationContext, NotificationManager::class.java) as NotificationManager
		notificationManager.sendNotification(messageBody, applicationContext)
	}

	private fun sendRegistrationToServer(token: String?) {
		// TODO: Implement this method to send token to your app server.
	}

	companion object {
		private const val TAG = "MyFirebaseMsgService"
	}
}