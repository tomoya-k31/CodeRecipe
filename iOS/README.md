iOS Recipe
==========

### Install Homebrew
```sh
ruby -e "$(curl -fsSL https://raw.github.com/Homebrew/homebrew/go/install)"
```



***
###  MacにRubyをインストールして複数バージョンの切り替え対応

###### rbenv, ruby-buildのインストール

```sh
brew install rbenv
brew install ruby-build
```
######（気が向けば）# 依存ライブラリのインストール

```sh
brew install readline
brew install openssl
```
###### .zshrcに設定を追加

```sh
eval "$(rbenv init -)"
```
###### rbenvで利用できるRubyのバージョンを確認

```sh
$ rbenv install -l
Available versions:
1.9.3-p392
1.9.3-p448
1.9.3-preview1
1.9.3-rc1
2.0.0-dev
2.0.0-p0
2.0.0-preview1
2.0.0-preview2
2.0.0-rc1
2.0.0-rc2
2.1.0-dev
jruby-1.5.6
….
```

###### Rubyをインストール

* 1.9.3をインストールします。

```sh
$ rbenv install 1.9.3-p448
$ rbenv rehash
```

* 2.0.0をインストールします。

```sh
$ rbenv install 2.0.0-p0
$ rbenv rehash
```

###### Rubyのバージョンを切り替える

* 1.9.3に設定してみます。

```sh
$ rbenv global 1.9.3-p448
$ ruby -v
```

* 2.0.0に設定してみます。

```sh
$ rbenv global 2.0.0-p0
$ ruby -v
```

###### インストール済みのバージョンを確認

```sh
$ rbenv versions
  system
  1.9.3-p392
  1.9.3-p426
  1.9.3-p448
  2.0.0-p0
* 2.0.0-p195 (set by /Users/asakura/Sites/ruby2/.ruby-version)
  2.0.0-p247
```

###### 古いバージョンをアンインストール

```sh
$ rbenv uninstall 1.9.3-p385
$ rbenv uninstall 2.0.0-p0
```

###### 必須のgemをインストール

```sh
gem install bundler
```


>参考サイト

* [rbenvとruby-buildでRuby環境を最新に保つ](https://gist.github.com/mochiz/4736183)
* [Mac OS X rbenvでRubyのバージョンを切り替える](http://www.happytrap.jp/blogs/2013/04/08/10394/)
* [MacにRubyをインストールする時のメモ](http://qiita.com/heki1224/items/5f74ae1b1cb5dc03cd36)



***
### MacのRubyGemsを最新に更新

```sh
$ sudo gem install rubygems-update
```
###### 一度PCの再起動

```sh
$ sudo update_rubygems
```
###### インストール or アップデートができたら、念のためバージョンを確認。

```sh
$ gem -v
```

> 参考サイト

* [Mac OS 10.8（Mountain Lion）にSASS + Compassをインストールするメモ](http://dounokouno.com/2012/11/14/mountain-ion-sass-compass/)
* [ツイッターBotを作るための準備](http://www.ruby-ruby.info/date/2013/06/14/)



***
### Homebrewで「brew update」をしたらエラーになった時の対処法


###### 長いこと更新作業を忘れるとでやすいエラー

```sh
$ brew update 
error: The following untracked working tree files would be overwritten by merge:
	Library/Formula/cabocha.rb
Please move or remove them before you can merge.
Aborting
Updating 7d2c1da..bfe50e3
Error: Failed while executing git pull  origin refs/heads/master:refs/remotes/origin/master
```

###### 対処の仕方は次のようにするとOK

```sh
$ cd /usr/local                                                                                                                               
$ git remote add origin git://github.com/mxcl/homebrew.git                                                                           
fatal: remote origin already exists.
$ git fetch origin
remote: Counting objects: 5, done.
remote: Compressing objects: 100% (1/1), done.
remote: Total 3 (delta 2), reused 3 (delta 2)
Unpacking objects: 100% (3/3), done.
From git://github.com/mxcl/homebrew
   4d2d66e..8a968e9  gh-pages   -> origin/gh-pages
$ git reset --hard origin/master                                                                                                     
HEAD is now at bfe50e3 shen: another style issue
```

###### うまくアップデートできた！

```sh
$ brew update                                                                                                                        
Already up-to-date.
```

***
### Install CocoaPods
```sh
$ sudo gem update --system
$ sudo gem update
$ sudo gem install cocoapods
$ sudo gem cleanup
$ pod setup
$ pod --version
```

> 参考サイト

* [開発レシピ：Objective-Cのライブラリ管理ツール CocoaPods](http://www.iosjp.com/dev/archives/451)


#### pod setupでerrorになった時の対処法

```sh
$ pod setup
Setting up CocoaPods master repo
[!] An error occurred while performing `git pull` on repo `master`.
[!] /usr/local/bin/git pull --ff-only

From https://github.com/CocoaPods/Specs

 + a076b5a...b27da90 master     -> origin/master  (forced update)

fatal: Not possible to fast-forward, aborting.
```

###### 念のためバックアップ
```sh
$ mv ~/.cocoapods ~/cocoapods
$ mv ~/Library/Caches/CocoaPods ~/CocoaPodsCaches
```

###### 再度実行
```sh
$ pod setup

# 新しいファイルが生成されていることを確認
$ ls ~/.cocoapods
$ ls ~/Library/Caches/CocoaPods

# バックアップを削除
$ rm -rf ~/cocoapods
$ $ rm -rf ~/CocoaPodsCaches
```

