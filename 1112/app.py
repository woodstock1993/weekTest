from flask import Flask, render_template, jsonify, request, Response
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.dbStock

@app.route('/')
def hello_world():  # put application's code here
    return render_template('index.html')


@app.route('/save', methods=['POST'])
def save_post():
    content = request.form.get('content')
    print(content)

    post = {
        'content': content
    }

    db.article.insert_one(post)
    return {"result": "success"}

if __name__ == '__main__':
    app.run()
