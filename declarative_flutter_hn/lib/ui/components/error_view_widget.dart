import 'package:declarative_flutter_hn/ui/main_bloc_provider.dart';
import 'package:flutter/material.dart';

import '../main_bloc.dart';

class ErrorViewWidget extends StatelessWidget {
  final String reason;

  ErrorViewWidget({this.reason});

  @override
  Widget build(BuildContext context) {
    MainBloc bloc = MainBlocProvider.of(context);

    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget>[
          Text(reason),
          SizedBox(height: 16.0),
          RaisedButton(
            onPressed: () {
              bloc.loadData();
            },
            child: const Text('Refresh', style: TextStyle(fontSize: 20)),
          ),
        ],
      ),
    );
  }
}
