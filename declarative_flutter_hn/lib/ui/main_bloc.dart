import 'package:declarative_flutter_hn/data/mock_news.dart';
import 'package:declarative_flutter_hn/data/model/app_state.dart';
import 'package:declarative_flutter_hn/data/model/news_state.dart';
import 'package:rxdart/rxdart.dart';

class MainBloc {
  final _appStateController = BehaviorSubject<AppState>();

  // Output
  Stream<AppState> get getAppState => _appStateController.stream;

  void dispose() {
    _appStateController.close();
  }

  void loadData() {
    _appStateController.add(AppState(newsState: LoadingState()));

    Future.delayed(const Duration(seconds: 2), () {
      _appStateController.add(AppState(newsState: SuccessState(newsList)));
    });
  }

  void generateError() {
    _appStateController.add(AppState(newsState: LoadingState()));

    Future.delayed(const Duration(seconds: 2), () {
      _appStateController.add(AppState(
          newsState: ErrorState(
              "This is a generated error only to try an error state")));
    });
  }
}
