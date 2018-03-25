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