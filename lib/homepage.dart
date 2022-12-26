import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  String? checkSenor;
  
  static const methodChannel = MethodChannel("com.hans.barometer/method");
  static const presurreChannel = EventChannel("com.hans.barometer/presure");

  Future<void> _checkAvailability() async {
    try{
      var available = await methodChannel.invokeMethod("isSensorAvailable");
      setState(() {
        checkSenor=available.toString();
      }); 
    } on PlatformException catch (e) {

    }
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(child: Column(
        children: [
          Text("is Sensor avilable ${checkSenor}"),
          ElevatedButton(onPressed:(){
            _checkAvailability();

          } ,child: Text("Check Sensor"),),
        ],
      ),
    )
    );
  }
}