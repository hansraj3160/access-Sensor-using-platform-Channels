package com.example.access_native_sensors_in_flutter

import io.flutter.embedding.android.FlutterActivity

class MainActivity: FlutterActivity() {
    private val METHOD_CHANNEL_NAME = "com.hans.barometer/method"
    private val PRESURE_CHANNEL_NAME = "com.hans.barometer/presure"


    private var methodChannel: MethodChannel? = null
    private lateinit var sensorManager: SensorManager
    
    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine){
        super.configureFlutterEngine(flutterEngine)

        setupChannels(this,flutterEngine.dartExecutor.binaryMessenger)         
    }
    override fun onDestroy(){
        teardownChannels()
        super.onDestroy()
    }
    private fun setupChannels(context:Context,messenger:BinaryMessenger){
        sensorManager=context.getSystemService(Context.SENSOR_SERVICE)AS Sensor Manar                                                                                                                                                                                                                                                       ]]    )

        methodChannel = MethodChannel(messenger, METHOD_CHANNEL_NAME)
        methodChannel!!.setMethodCallH andler{
            call, result =>
            if(call.method == "isSensorAvailable"){
               result.success(sensorManager!!.getSensorList(call.arguments as Int).isNotEmpty())
            }else
            {
                result.notImplemented()
            }
        }
    }
    private fun teardownChannels(){
        methodChannel!!.setMethodCallHandler(null)
    }
}
