package org.sopt.careerly_android.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.*
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL


object ImageDownloadManager {

    @ExperimentalCoroutinesApi
    @DelicateCoroutinesApi
    suspend fun getImage(url: String): Bitmap = suspendCancellableCoroutine { continuation ->
        val urlConnection = URL(url).openConnection() as HttpURLConnection
        GlobalScope.launch(Dispatchers.IO) {
            try {
                if (urlConnection.responseCode == 200) {
                    val stream = BufferedInputStream(urlConnection.inputStream)
                    val bitmap = BitmapFactory.decodeStream(stream)
                    continuation.resume(bitmap) {}
                }
            } catch (e: Exception) {

            } finally {
                urlConnection.disconnect()
            }
        }
    }
}
