module Even where
    allEven :: [Integer] -> [Integer]
    allEven [] = []
    allEven (h:t) = if even h then h:allEven t else allEven t

    allEvenPatternMatching :: [Integer] -> [Integer]
    allEvenPatternMatching [] = []
    allEvenPatternMatching i = filter even i