//
//  MainViewModel.swift
//  Declarative iOs HN
//
//  Created by Marco Gomiero on 14/02/2020.
//  Copyright © 2020 Marco Gomiero. All rights reserved.
//

import Foundation
import SwiftUI
import Combine

class MainViewModel: ObservableObject {
    
    @Published private(set) var appState: AppState = AppState()
    
    func loadData() {
        self.appState = AppState(newsState: Loading())
        DispatchQueue.main.asyncAfter(deadline: .now() + 2.0) {
            self.appState = AppState(newsState: Success(news: newsList))
        }
    }
    
    func generateError() {
        self.appState = AppState(newsState: Loading())
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 2.0) {
            self.appState = AppState(newsState: Error(reason: "This is a generated error only to try an error state"))
        }
    }
}
