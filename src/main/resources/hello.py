import nltk
import sys

from nltk.sentiment.vader import SentimentIntensityAnalyzer
sid = SentimentIntensityAnalyzer()
scores = sid.polarity_scores(sys.argv[1])
for k in sorted(scores):
    print('{0}: {1}, '.format(k, scores[k]), end='')
