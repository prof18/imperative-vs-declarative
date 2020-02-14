//
//  AppState.swift
//  Imperative iOs HN
//
//  Created by Marco Gomiero on 14/02/2020.
//  Copyright © 2020 Marco Gomiero. All rights reserved.
//

import Foundation

class AppState {
    let newsState: NewsState
    
    init(newsState: NewsState) {
        self.newsState = newsState
    }
    
}
