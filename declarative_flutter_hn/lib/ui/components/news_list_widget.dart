import 'package:declarative_flutter_hn/data/model/news.dart';
import 'package:declarative_flutter_hn/ui/components/news_card_widget.dart';
import 'package:flutter/material.dart';

class NewsListWidget extends StatelessWidget {
  final List<News> newsList;
  NewsListWidget({this.newsList});

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemBuilder: (context, position) {
        return NewsCardWidget(news: newsList[position]);
      },
      itemCount: newsList.length,
    );
  }
}
