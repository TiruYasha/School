module Sort where
-- Write a sort that takes a list and returns a sorted list.

sortList :: [Integer] -> [Integer]
sortList [] = []
sortList (h:t) = insert h (sortList t)
  where
  insert i [] = [i]
  insert i (sh:st) = if (i < sh) then i:sh:st else sh:(insert i st)



-- Write a sort that takes a list and a function that compares its two arguments and then returns a sorted list.

sortListBy fun [] = []
sortListBy fun (h:t) = insert fun h (sortListBy fun t)
  where
  insert fun i [] = [i]
  insert fun i (sh:st) = if (fun i sh) then i:sh:st else sh:(insert fun i st)


-- Write a Haskell function to convert a string to a number. The string should be in the form of $2,345,678.99 and can possibly have leading zeros.
stringToFloat :: [Char] -> Float
stringToFloat list = stringToNum (filter (not . (`elem` ",")) list) 

stringToNum :: [Char] -> Float
stringToNum (h:t) = if (isNumeric [h]) then read (h:t) :: Float else read t :: Float
    where
    isNumeric char = case reads char :: [(Integer, String)] of
        [(_, "")] -> True
        _         -> False

-- Write a function that takes an argument x and returns a lazy sequence that has every third number, starting with x. Then, write a function that includes every fifth number, beginning with y. Combine these functions through composition to return every eighth number, beginning with x + y.

third y = [y, (y + 3) ..]

fifth i = [i, (i + 5) ..]

lazyEight x y = zipWith(+) (third x) (fifth y)


-- Use a partially applied function to define a function that will return half of a number and another that will append \n to the end of any string.

half = (/2)

whiteLine = (++ "\n")

-- Write a function to determine the greatest common denominator of two integers.

denominators x = divisors x 1 where
  divisors x by = if (x `mod` by == 0) then by:(divisors x (by + 1)) else (if (by > x) then [] else divisors x ( by + 1))
    
myGcd x y = findPair (sortListBy (>=) ((denominators x) ++ (denominators y))) where
  findPair (h1:h2:t) = if (h1 == h2) then h1 else findPair (h2:t)

-- Create a lazy sequence of prime numbers.

lazyPrime = nextPrime 1 where
  nextPrime x = if (length (denominators x) <= 2) then x:(nextPrime (x + 1)) else nextPrime(x+1) 
    
--

breakLineAt x string = insertBreak x 0 string [] where
  insertBreak breakPoint wordCount (h:t) collected
    | wordCount == breakPoint = insertBreak breakPoint 0 (h:t) (collected ++ "\n")
    | [h] == " "              = insertBreak breakPoint (wordCount + 1) t (collected ++ [h])
    | t == []                 = collected ++ [h]
    | otherwise               = insertBreak breakPoint wordCount t (collected ++ [h])