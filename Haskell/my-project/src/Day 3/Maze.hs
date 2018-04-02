module Maze where
    --import Control.Monad (mfilter)
    import Data.List
    import Control.Monad

    data Coordinate = Coordinate Int Int deriving(Show, Eq, Ord)
    data Node = Node 
        {
            coordinate :: Coordinate,
            exits :: [Node],
            isFinish :: Bool,
            name :: [Char]
        } deriving (Show, Eq, Ord) 
    data Maze = Maze [Node] deriving (Show)

    returnNodeByCoordinates :: Maze -> Coordinate-> [Node]
    returnNodeByCoordinates (Maze nodes) c = filter (\n -> coordinate n == c) nodes
        

    n1 = Node{ 
        coordinate = (Coordinate 2 1),
        exits = [n2], 
        isFinish = False,
        name= "n1" 
    }
    n2 = Node{
        coordinate = (Coordinate 2 2),
        exits = [n3, n4], 
        isFinish = False,
        name= "n2"
    } 
    n3 = Node{ 
        coordinate = (Coordinate 1 2),
        exits = [n5], 
        isFinish = False,
        name= "n3" 
    }
    n4 = Node {
        coordinate = (Coordinate 3 2), 
        exits = [], 
        isFinish = False,
        name= "n4"
    }
    n5 = Node { 
        coordinate = (Coordinate 1 3), 
        exits = [n6, n7], 
        isFinish = False,
        name= "n5"
    }
    n6 = Node { 
        coordinate = (Coordinate 2 3), 
        exits = [n8], 
        isFinish = False,
        name= "n6"  
    }
    n7 = Node { 
        coordinate = (Coordinate 0 3), 
        exits = [], 
        isFinish = True,
        name= "n7"  
    }
    n8 = Node { 
        coordinate = (Coordinate 2 4), 
        exits = [], 
        isFinish = False,
        name= "n8" 
    }

    mazeToSolve = Maze [n1, n2, n3, n4, n5, n6, n7, n8]

    crack = do x <- ['a'..'c' ] ; y <- ['a'..'c' ] ; z <- ['a'..'c' ];
                let { password = [x, y, z] } ;
                if attempt password
                    then return (password, True)
                    else return (password, False)
    
    attempt pw = if pw == "cab" then True else False
                            
    -- mazeThingy :: Node -> [Char] -> [Char]
    -- mazeThingy node names =
    --         do n <- exits node;
    --                             let { 
    --                                     next = n;
    --                                     --namet = name n;
    --                                     --names++name n;
    --                                 };
    --                             if isFinish next == True
    --                                 then names:[name n
    --                                 else names:(mazeThingy n name n)

    

    all_exits node acc 
        | exits node == [] = [node]
        | otherwise    =
        do n <- exits node;
                let { nextLot = all_exits n acc };
                    (node:nextLot)

    solve start_node =
        let (pathNodes,finishNodes) = break (\n -> isFinish n == True ) $ all_exits start_node []
        in
            if length finishNodes < 1 then   -- we didn't get a solution
                [] 
            else
                pathNodes++[head finishNodes]
    --returnNode c = returnNodeByCoordinates (Maze [Node (Coordinate 4 5) [], Node (Coordinate 6 6) [] ]) c
    -- [(Node (Coordinate 1 1) [])(Node (Coordinate 2 2) [])] (Coordinate 2 2)
