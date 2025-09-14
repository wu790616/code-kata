(ns interest-is-interesting)

(defn interest-rate
  "Calculate the interest rate based on the specified balance"
  [balance]
  (cond
    (neg? balance)   -3.213
    (< balance 1000) 0.5
    (< balance 5000) 1.621
    :else            2.475))

(defn annual-balance-update
  "Calculate the annual balance update"
  [balance]
  (let [rate-percent (bigdec (Math/abs (/ (interest-rate balance) 100)))
        amount       (* balance rate-percent)]
    (+ balance amount)))

(defn amount-to-donate
  "Calculate how much money to donate to charities"
  [balance tax-free-percentage]
  (let [rate (if (neg? balance) 0 (/ tax-free-percentage 100))]
    (int (* balance rate 2))))
