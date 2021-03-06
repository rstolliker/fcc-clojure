(ns random-quote-generator.core
  (:require
   [reagent.core :as reagent]
   ))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Vars

(defonce app-state
  (reagent/atom {:quote "Click to get a random quote! Yay!"}))

(defonce quotes [
                 "Anyhthing is possible but nothing is easy. -Alan Perlis" "It's turtles all the way down. -XCKD" "Life is about making an impact, not making an income. -Kevin Kruse" "Whatever the mind of man can conceive and believe, it can achieve. -Napoleon Hill" "Strive not to be a success, but rather to be of value. -Albert Einstein" "You miss 100% of the shots you donÆt take. -Wayne Gretzky" "The most difficult thing is the decision to act, the rest is merely tenacity. -Amelia Earhart" "We become what we think about. -Earl Nightingale" "The most common way people give up their power is by thinking they donÆt have any. -Alice Walker" "The mind is everything. What you think you become.  -Buddha" "The best time to plant a tree was 20 years ago. The second best time is now. -Chinese Proverb" "An unexamined life is not worth living. -Socrates" "Eighty percent of success is showing up. -Woody Allen" "Your time is limited, so donÆt waste it living someone elseÆs life. -Steve Jobs" "The two most important days in your life are the day you are born and the day you find out why. -Mark Twain" "The best revenge is massive success. -Frank Sinatra" "If you hear a voice within you say ôyou cannot paint,ö then by all means paint and that voice will be silenced. -Vincent Van Gogh" "There is only one way to avoid criticism: do nothing, say nothing, and be nothing. -Aristotle" "Ask and it will be given to you; search, and you will find; knock and the door will be opened for you. -Jesus" "Few things can help an individual more than to place responsibility on him, and to let him know that you trust him. -Booker T. Washington" "Certain things catch your eye, but pursue only those that capture the heart. - Ancient Indian Proverb" "We can easily forgive a child who is afraid of the dark; the real tragedy of life is when men are afraid of the light. -Plato" "When I was 5 years old, my mother always told me that happiness was the key to life.  When I went to school, they asked me what I wanted to be when I grew up.  I wrote down æhappyÆ.  They told me I didnÆt understand the assignment, and I told them they didnÆt understand life. -John Lennon" "How wonderful it is that nobody need wait a single moment before starting to improve the world. -Anne Frank" "When I let go of what I am, I become what I might be. -Lao Tzu" "Life is not measured by the number of breaths we take, but by the moments that take our breath away. -Maya Angelou" "Happiness is not something readymade.  It comes from your own actions. -Dalai Lama" "If youÆre offered a seat on a rocket ship, donÆt ask what seat! Just get on. -Sheryl Sandberg" "We must believe that we are gifted for something, and that this thing, at whatever cost, must be attained. -Marie Curie" "Too many of us are not living our dreams because we are living our fears. -Les Brown" "If you want to lift yourself up, lift up someone else. -Booker T. Washington" "WhatÆs money? A man is a success if he gets up in the morning and goes to bed at night and in between does what he wants to do. -Bob Dylan" "A person who never made a mistake never tried anything new. - Albert Einstein" "The person who says it cannot be done should not interrupt the person who is doing it. -Chinese Proverb"
                 ])



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Page

(defn page [ratom]
  [:div {:class "container jumbotron text-center"
         :id "outer"}
   [:div {:class "row"} [:h1 {:id "title"} "Random Quote Generator"]]
   [:div {:class "row"} [:p {:id "quote-space"} (:quote @ratom)]]
   [:div {:class "row"}
    [:button {:class "btn btn-primary"
              :id "get-quote"
              :on-click #(swap! ratom assoc-in [:quote] (rand-nth quotes))}
     "Give me a quote"]]])



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Initialize App

(defn dev-setup []
  (when ^boolean js/goog.DEBUG
    (enable-console-print!)
    (println "dev mode")
    ))

(defn reload []
  (reagent/render [page app-state]
                  (.getElementById js/document "app")))

(defn ^:export main []
  (dev-setup)
  (reload))
