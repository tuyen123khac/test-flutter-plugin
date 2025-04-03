import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:ble_plugin_test/ble_plugin_test.dart';

void main() {
  BlePluginTest.subscribePluginEvents();
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';
  final _blePluginTestPlugin = BlePluginTest();

  @override
  void initState() {
    super.initState();
    init();
  }

  Future<void> init() async {
    initPlatformState();
    listenEvent();
    await Future.delayed(const Duration(seconds: 2));
    BlePluginTest.checkPermission();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    String platformVersion;
    // Platform messages may fail, so we use a try/catch PlatformException.
    // We also handle the message potentially returning null.
    try {
      platformVersion =
          await _blePluginTestPlugin.getPlatformVersion() ?? 'Unknown platform version';
    } on PlatformException {
      platformVersion = 'Failed to get platform version.';
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _platformVersion = platformVersion;
    });
  }

  void listenEvent() {
    BlePluginTest.listenFoundDevice(
      (p0) {
        print(' Found devoce : ${p0}');
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
          appBar: AppBar(
            title: const Text('Plugin example app'),
          ),
          body: Center(
            child: Text('Running on: $_platformVersion\n'),
          ),
          floatingActionButton: Column(mainAxisAlignment: MainAxisAlignment.end, children: [
            FloatingActionButton(
              child: Icon(Icons.stop),
              onPressed: () {
                BlePluginTest.stopScan();
              },
              heroTag: null,
            ),
            SizedBox(
              height: 10,
            ),
            FloatingActionButton(
              child: Icon(Icons.star),
              onPressed: () {
                BlePluginTest.startScan();
              },
              heroTag: null,
            )
          ])),
    );
  }
}
