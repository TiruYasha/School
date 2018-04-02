module Challenge where

    data Dungeon = Dungeon [Node]

    data Node = Node{
        name :: String,
        nodes :: [Node]
    }

    data Settings = Settings{
        depth :: Int,
        maxNodesPerNode :: Int,
        nodeTypes :: [(String, Int)],
        startType :: String,
        endType ::String
    }

    
    createDungeon settings dungeon =  



    printDungeon dungeon = do{
        putStrLn "dungeon";
    }