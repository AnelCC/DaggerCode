package com.anelcc.daggertohilt.settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.anelcc.daggertohilt.MyApplication
import com.anelcc.daggertohilt.R
import com.anelcc.daggertohilt.login.LoginActivity
import com.anelcc.daggertohilt.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

@AndroidEntryPoint
class SettingsActivity : AppCompatActivity() {

    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        //val userManager = (application as MyApplication).appComponent.userManager()
        //userManager.userComponent!!.inject(this)
       /* val entryPoint = EntryPointAccessors
            .fromApplication(applicationContext, MainActivity.UserManagerEntryPoint::class.java)
        val userManager = entryPoint.userManager()*/

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setupViews()
    }

    private fun setupViews() {
        findViewById<Button>(R.id.refresh).setOnClickListener {
            settingsViewModel.refreshNotifications()
        }
        findViewById<Button>(R.id.logout).setOnClickListener {
            settingsViewModel.logout()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}
