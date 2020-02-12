import 'package:intl/intl.dart';

class News {
  String by;
  int id;
  int score;
  String text;
  int time;
  String title;
  String type;
  String url;

  String getStringTime() {
    var formatter = new DateFormat('d MMM yyyy');
    String formatted =
        formatter.format(DateTime.fromMillisecondsSinceEpoch(time * 1000));
    return formatted;
  }

  News(
      {this.by,
      this.id,
      this.score,
      this.text,
      this.time,
      this.title,
      this.type,
      this.url});
}
