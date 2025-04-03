import 'package:flutter_test/flutter_test.dart';
import 'package:ble_plugin_test/ble_plugin_test.dart';
import 'package:ble_plugin_test/ble_plugin_test_platform_interface.dart';
import 'package:ble_plugin_test/ble_plugin_test_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockBlePluginTestPlatform
    with MockPlatformInterfaceMixin
    implements BlePluginTestPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final BlePluginTestPlatform initialPlatform = BlePluginTestPlatform.instance;

  test('$MethodChannelBlePluginTest is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelBlePluginTest>());
  });

  test('getPlatformVersion', () async {
    BlePluginTest blePluginTestPlugin = BlePluginTest();
    MockBlePluginTestPlatform fakePlatform = MockBlePluginTestPlatform();
    BlePluginTestPlatform.instance = fakePlatform;

    expect(await blePluginTestPlugin.getPlatformVersion(), '42');
  });
}
