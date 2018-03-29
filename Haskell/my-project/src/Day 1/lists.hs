module Lists where
    size [] = 0
    size (h:t) = 1 + size t

    prod [] = 1
    prod (h:t) = h * prod t

    reverseList :: [Integer] -> [Integer] -> [Integer]

    reverseList l [] = l
    reverseList l (h:t) = reverseList (h:l) t

    listMultiplication :: Integer->Integer-> (Integer,Integer,Integer)
    listMultiplication value multiplyBy = (value, multiplyBy, value * multiplyBy)

    data Color = Red | Green| Blue

    -- | Tennessee - Mississippi - Alabama - Georgia
    -- | Mississipi - Tennessee - Alabama
    -- | Alabama - all
    -- | Georgia - Tennessee - Florida- Alabama
    -- | Florida - Georgia - Alabama
    
    coloring :: [([Char], [Char])] -> [([Char], [Char])]
    coloring [] = []
    -- coloring [(state, neighbour)] = 