import 'package:declarative_flutter_hn/ui/main_bloc.dart';
import 'package:flutter/material.dart';

class MainBlocProvider extends InheritedWidget {
  final MainBloc mainBloc;

  MainBlocProvider({Key key, MainBloc mainBloc, Widget child})
      : mainBloc = mainBloc ?? MainBloc(),
        super(key: key, child: child);

  // If returns true, updates all the depends elements
  @override
  bool updateShouldNotify(InheritedWidget oldWidget) {
    return true;
  }

  static MainBloc of(BuildContext context) =>
      context.dependOnInheritedWidgetOfExactType<MainBlocProvider>().mainBloc;
}
