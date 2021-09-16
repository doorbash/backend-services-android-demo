package backend.services.demo

import android.R
import android.app.Application
import backend.services.Client
import backend.services.ClientOptions
import backend.services.notifications.BackendServicesNotificationsClient
import backend.services.rc.BackendServicesRemoteConfigClient

class App : Application() {
    override fun onCreate() {
        Client.init(
            this, ClientOptions(
                BuildConfig.VERSION_CODE,
                "com.example.project",
                "https://doorbash.ir/api",
                10,
                false,
                R.drawable.btn_star
            )
        )
        BackendServicesNotificationsClient.enqueueWorker(this)
        BackendServicesRemoteConfigClient.enqueueWorker(this)
        super.onCreate()
    }
}