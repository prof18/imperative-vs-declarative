//
//  MainViewModel.swift
//  Imperative iOs HN
//
//  Created by Marco Gomiero on 14/02/2020.
//  Copyright © 2020 Marco Gomiero. All rights reserved.
//

import Foundation

class MainViewModel {
    
    func loadData() {
        let loadingAppState = AppState(newsState: Loading())
        NotificationCenter.default.post(name: NSNotification.Name(rawValue: "appState"), object: nil, userInfo: ["appState": loadingAppState])
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 2.0) {
            let successState = AppState(newsState: Success(news: newsList))
            NotificationCenter.default.post(name: NSNotification.Name(rawValue: "appState"), object: nil, userInfo: ["appState": successState])
        }
    }
    
    func generateError() {
        let loadingAppState = AppState(newsState: Loading())
        NotificationCenter.default.post(name: NSNotification.Name(rawValue: "appState"), object: nil, userInfo: ["appState": loadingAppState])
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 2.0) {
            let errorState = AppState(newsState: Error(reason: "This is a generated error only to try an error state"))
            NotificationCenter.default.post(name: NSNotification.Name(rawValue: "appState"), object: nil, userInfo: ["appState": errorState])
        }
    }
}
