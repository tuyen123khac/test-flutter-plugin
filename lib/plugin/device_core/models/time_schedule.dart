// ignore_for_file: public_member_api_docs, sort_constructors_first

import 'package:ble_plugin_test_example/plugin/device_core/models/model_enums.dart';

class TimeSchedule {
  final int hour;
  final int minute;
  final TimePeriod timePeriod;

  TimeSchedule({
    required this.hour,
    required this.minute,
    required this.timePeriod,
  });

  @override
  String toString() => 'TimeSchedule(hour: $hour, minute: $minute, timePeriod: $timePeriod)';
}
