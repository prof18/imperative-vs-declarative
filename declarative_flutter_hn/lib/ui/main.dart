import 'package:declarative_flutter_hn/data/model/app_state.dart';
import 'package:declarative_flutter_hn/data/model/news_state.dart';
import 'package:declarative_flutter_hn/ui/components/loading_view_widget.dart';
import 'package:declarative_flutter_hn/ui/components/error_view_widget.dart';
import 'package:declarative_flutter_hn/ui/components/news_list_widget.dart';
import 'package:declarative_flutter_hn/ui/main_bloc.dart';
import 'package:declarative_flutter_hn/ui/main_bloc_provider.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Declarative Flutter HN'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  MainBloc bloc = MainBloc();

  @override
  void initState() {
    super.initState();
    bloc.generateError();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: MainBlocProvider(
        mainBloc: bloc,
        child: getWidgetByState(),
      ),
    );
  }

  Widget getWidgetByState() {
    return StreamBuilder<AppState>(
      stream: bloc.getAppState,
      builder: (BuildContext context, AsyncSnapshot snapshot) {
        if (snapshot.hasData) {
          AppState state = snapshot.data;
          if (state.newsState is LoadingState) {
            return LoadingViewWidget();
          } else if (state.newsState is ErrorState) {
            ErrorState errorState = state.newsState as ErrorState;
            return ErrorViewWidget(reason: errorState.reason);
          } else {
            SuccessState successState = state.newsState as SuccessState;
            return NewsListWidget(newsList: successState.news);
          }
        } else {
          return Container();
        }
      },
    );
  }
}
