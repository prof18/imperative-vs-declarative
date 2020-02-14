//
//  ViewController.swift
//  Imperative iOs HN
//
//  Created by Marco Gomiero on 12/02/2020.
//  Copyright © 2020 Marco Gomiero. All rights reserved.
//

import UIKit

class MainViewController: UIViewController {
    
    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var errorButton: UIButton!
    @IBOutlet weak var errorLabel: UILabel!
    @IBOutlet weak var loader: UIActivityIndicatorView!
    
    private var newsList = [News]()
    private var viewModel = MainViewModel()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.setupObservers()
        
        self.title = "Imperative iOs HN"
        
        let newsCell = UINib(nibName: "NewsCard", bundle: nil)
        self.tableView.register(newsCell, forCellReuseIdentifier: "NewsCell")
        
        self.tableView.dataSource = self
        self.tableView.delegate = self
        self.tableView.translatesAutoresizingMaskIntoConstraints = false
        self.tableView.separatorStyle = .none
        
        self.viewModel.generateError()
    }
    
    private func setupObservers() {
        NotificationCenter.default.addObserver(self, selector: #selector(onDidReceiveData(_:)), name: NSNotification.Name(rawValue: "appState"), object: nil)
    }
    
    @objc func onDidReceiveData(_ notification:Notification) {
        // Do something now
        
        if let data = notification.userInfo as? [String: AppState] {
            
            let state: AppState? = data["appState"]
            
            switch state?.newsState {
            case _ as Loading:
                
                self.errorButton.isHidden = true
                self.errorLabel.isHidden = true
                self.tableView.isHidden = true
                
                self.loader.isHidden = false
                self.loader.startAnimating()
                
            case let error as Error:
                
                self.loader.stopAnimating()
                self.loader.isHidden = true
                self.tableView.isHidden = true
                
                self.errorButton.isHidden = false
                self.errorLabel.isHidden = false
                self.errorLabel.text = error.reason
                
            case let success as Success:
                
                self.loader.stopAnimating()
                self.loader.isHidden = true
                self.errorButton.isHidden = true
                self.errorLabel.isHidden = true
                
                self.newsList = success.news
                self.tableView.isHidden = false
                self.tableView.reloadData()
                
            default:
                break
            }
        }
    }
    
    @IBAction func didTapOnErrorButton(_ sender: Any) {
        self.viewModel.loadData()
    }
}

extension MainViewController: UITableViewDelegate, UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.newsList.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "NewsCell", for: indexPath) as! NewsCard
        cell.backgroundColor = UIColor.clear
        cell.selectionStyle = .none
        
        if !newsList.isEmpty {
            let news = self.newsList[indexPath.row]
            cell.setup(title: news.title, date: news.getStringTime())
        }
        
        return cell
    }
    
    func tableView(_ tableView: UITableView, willDisplay cell: UITableViewCell, forRowAt indexPath: IndexPath) {
        // Cell shadow stuff
        cell.contentView.layer.masksToBounds = true
        let radius = cell.contentView.layer.cornerRadius
        cell.layer.shadowPath = UIBezierPath(roundedRect: cell.bounds, cornerRadius: radius).cgPath
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        print("item selected")
        let news = self.newsList[indexPath.row]
        if let newsUrl = news.url {
            if let url = URL(string: newsUrl), !url.absoluteString.isEmpty {
                UIApplication.shared.open(url, options: [:], completionHandler: nil)
            }
        }
    }
}
