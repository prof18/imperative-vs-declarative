import 'package:declarative_flutter_hn/data/model/news.dart';

abstract class NewsState {}

class LoadingState implements NewsState {}

class SuccessState implements NewsState {
  final List<News> news;
  SuccessState(this.news);
}

class ErrorState implements NewsState {
  final String reason;
  ErrorState(this.reason);
}
