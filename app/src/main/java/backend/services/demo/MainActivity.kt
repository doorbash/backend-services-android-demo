package backend.services.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import backend.services.Client
import backend.services.ClientOptions
import backend.services.notifications.BackendServicesNotificationsClient
import backend.services.rc.BackendServicesRemoteConfigClient


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Client.init(this, ClientOptions(
            BuildConfig.VERSION_CODE,
            "com.example.project",
            "https://doorbash.ir/api",
            10,
            false,
            android.R.drawable.btn_star,
            MainActivity::class.java
        ))
        BackendServicesNotificationsClient.enqueueWorker(this)
        BackendServicesRemoteConfigClient.enqueueWorker(this)
    }
}