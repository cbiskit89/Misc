;;; mylab.lisp
;;; by Cory Miller

;; Greatest common divisor
(defun mygcd (a b)
  (if (= a b) a)
  (if (< a b)
      (mygcd b a))
  (if (and (>= a b) (integerp (/ a b)))
      b
    (mygcd a (- b 1))))

;; Delete element e from list
(defun delete_elem (a b)
  (setq a (delete b a)))
  

;; Merge list of lists into simple list
(defun flatten (a)
  (let ((result '()))
    (labels ((scan (item)
		   (if (listp item)
		       (map nil #'scan item)
		     (push item result))))
	    (scan a))
	    (nreverse result)))

;; Delete element of list if lambda argument
;; evaluates to true

;; A function that takes an integer to the
;; n'th power