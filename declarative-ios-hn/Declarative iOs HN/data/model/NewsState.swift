//
//  NewsState.swift
//  Declarative iOs HN
//
//  Created by Marco Gomiero on 14/02/2020.
//  Copyright © 2020 Marco Gomiero. All rights reserved.
//

import Foundation

protocol NewsState {}

struct Loading: NewsState {}
struct Success: NewsState {
    let news: [News]
    
    init(news: [News]) {
        self.news = news
    }
}
struct Error: NewsState {
    let reason: String
    
    init(reason: String) {
        self.reason = reason
    }
}
