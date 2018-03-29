module Lists where
    size [] = 0
    size (h:t) = 1 + size t

    prod [] = 1
    prod (h:t) = h * prod t

    reverseList :: [Integer] -> [Integer] -> [Integer]

    reverseList l [] = l
    reverseList l (h:t) = reverseList (h:l) t