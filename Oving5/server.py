from flask import Flask, render_template, request
from flask_cors import CORS, cross_origin
import io, sys


app = Flask(__name__)
CORS(app)
app.config['CORS_HEADERS'] = 'Content-Type'

@app.route("/snekker", methods=['GET'])
def hostRact():  
    return '<h1>Snekker</h1>'

@app.route("/calc", methods = ['POST']) 
def execute(): 
    body = request.json
    calc = body.get('calculation')
    print(calc)
    response = eval(calc)
    return { "result": response }



if __name__ == "__main__":
    app.run()